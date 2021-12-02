import React, { Component } from "react";
import Item from "../../components/Item";
import List from "../../components/List";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import { Fab } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import ViewStreamIcon from "@mui/icons-material/ViewStream";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            carts: [],
            cartHidden: true,
            isLoading: false,
            isCreate: false,
            isEdit: false,
            search: "",
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.handleAddToCart = this.handleAddToCart.bind(this);
        this.handleDeleteAllItem = this.handleDeleteAllItem.bind(this);
        this.loadData = this.loadData.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    handleSearch(event) {
        this.setState({
            search: event.target.value.substr(0, 20),
        });
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({
            isLoading: !currentLoading
        });
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({
            isCreate: true
        });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({
            isCreate: false,
            isEdit: false
        });
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    handleDeleteAllItem = () => {
        this.setState({ carts: []});
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        }
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        }
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteItem(id) {
        try {
            await APIConfig.delete(`/item/${id}`);
            this.loadData();
        }
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadData() {
        try {
            const {data} = await APIConfig.get("/item");
            this.setState({items: data.result});
        }
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadDataCart() {
        try {
            const {data} = await APIConfig.get("/cart");
            this.setState({carts: data.result});
        }
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleAddToCart(event) {
        try {
            const input = document.getElementById("inputstock" + event.id);
            const qty = input.value;
            const carts = [...this.state.carts];
            console.log(carts);
            if (carts.length === 0) {
                if (qty <= event.quantity) {
                    const data = {
                        quantity: input.value,
                        id: event.id,
                    };
                    await APIConfig.post("/cart", data);
                    this.loadData();
                    this.loadDataCart();
                }
                else {
                    alert("Stok tidak memenuhi");
                }
                for (let index = 0; index < carts.length; index++) {
                    const element = carts[index];
                    console.log(element);
                    if (event.id === element.item.id) {
                        if (qty <= event.quantity - element.quantity) {
                            const data = {
                                quantity: input.value,
                                id: event.id,
                            };
                            await APIConfig.post("/cart", data);
                            this.loadData();
                            this.loadDataCart();
                        }
                        else {
                            alert("Stok tidak memenuhi");
                        }
                    }
                    else {
                        if (qty <= event.quantity) {
                            const data = {
                                quantity: input.value,
                                id: event.id,
                            };
                            await APIConfig.post("/cart", data);
                            this.loadData();
                            this.loadDataCart();
                        }
                        else {
                            alert("Stok tidak memenuhi");
                        }
                    }
                }
            }
        }
        catch (error) {
            alert("Item berhasil ditambahkan ke cart");
            console.log(error);
        }
    }

    render() {
        let filteredItem = this.state.items.filter((item) => {
            return (
                item.title
                    .toLowerCase()
                    .indexOf(this.state.search.toLowerCase()) !== -1
            );
        });

        return (
            <div className = {classes.itemList}>
                <div style = {{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant = "extend" onClick = {this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color = "secondary" badgeContent = {this.state.carts.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>

                <div className="container pt-3">
                    <div className = "row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <Button
                                    style = {{ color: "white", background: "#3C91E6" }}
                                >
                                    BACK
                                </Button>
                                <Button
                                    style = {{ color: "white", background: "#3C91E6" }}
                                    onClick = {this.handleDeleteAllItem}
                                >
                                    CHECKOUT
                                </Button>
                                <h1 className = {classes.title}>Cart Items</h1>
                                <List
                                    items = {this.state.carts}
                                    isShopList = {false}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                            <h1 className = {classes.title}>All Items</h1>
                            <div>
                                <h3>Cari Item</h3>
                                <input
                                    className = {classes.textField}
                                    type = "text"
                                    placeholder = "Masukkan nama item"
                                    onChange = {this.handleSearch.bind(this)}
                                />
                            </div>
                            <Button action = {this.handleAddItem}>
                                Add Item
                            </Button>
                            <div>
                                { filteredItem.map((item) => (
                                    <Item
                                        key = {item.id}
                                        id = {item.id}
                                        title = {item.title}
                                        price = {item.price}
                                        description = {item.description}
                                        category = {item.category}
                                        quantity = {item.quantity}
                                        handleEdit = {() => this.handleEditItem(item)}
                                        handleDelete = {() => this.handleDeleteItem(item.id)}
                                        addToCart = {() => this.handleAddToCart(item)}
                                    />
                                ))}
                            </div>

                            <Modal
                                show = {this.state.isCreate || this.state.isEdit}
                                handleCloseModal = {this.handleCancel}
                                modalTitle = {this.state.isCreate
                                    ? "Add Item"
                                    : `Edit Item ID ${this.state.id}`} >
                                <form>
                                    <input
                                        className = {classes.textField}
                                        type = "text"
                                        placeholder = "Nama Barang"
                                        name = "title"
                                        value = {this.state.title}
                                        onChange = {this.handleChangeField}
                                    />
                                    <input
                                        className = {classes.textField}
                                        type = "number"
                                        placeholder = "Harga"
                                        name = "price"
                                        value = {this.state.price}
                                        onChange={this.handleChangeField}
                                    />
                                    <textarea
                                        className = {classes.textField}
                                        placeholder = "Deskripsi"
                                        name = "description"
                                        rows = "4"
                                        value = {this.state.description}
                                        onChange={this.handleChangeField}
                                    />
                                    <input
                                        className = {classes.textField}
                                        type = "text"
                                        placeholder = "Kategori"
                                        name = "category"
                                        value = {this.state.category}
                                        onChange = {this.handleChangeField}
                                    />
                                    <input
                                        className = {classes.textField}
                                        type = "number"
                                        placeholder = "Stok"
                                        name = "quantity"
                                        value = {this.state.quantity}
                                        onChange = {this.handleChangeField}
                                    />
                                    <Button
                                        action = {this.state.isCreate ? this.handleSubmitItem : this.handleSubmitEditItem}
                                    > Creates
                                    </Button>
                                    <Button
                                        action = {this.handleCancel}
                                    > Cancel
                                    </Button>
                                </form>
                            </Modal>

                        </div>}
                    </div>
                </div>
            </div>
        );
    }
}

export default ItemList;
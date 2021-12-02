import React from "react";
import Button from "../../components/Button";

import classes from "./styles.module.css";
    const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete, addToCart} = props;
    return (
        <div className = {classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Description: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <p>{`Stok: ${quantity}`}</p>
            <Button action = {handleEdit}>
                Edit
            </Button>
            <Button action = {handleDelete}>
                Delete
            </Button>
            <div className = "space-x-2">
                <input
                    id = {`inputstock${id}`}
                    placeholder = "Add kuantitas barang"
                    className = "border-2 w-64 rounded-md"
                />
                <Button action = {addToCart} >Add to Cart</Button>
            </div>
        </div>
    ); };

export default Item;
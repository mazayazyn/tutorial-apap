import React from "react";
import Button from "../../components/Button";

import classes from "./styles.module.css"; const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete} = props;
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
        </div>
    ); };

export default Item;
import React from "react";
import Button from "../button";
import classes from "./styles.module.css";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete, handleAdd,handleJumalahQ} = props;
        return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <br/>
            
    
            
            <input
                className={classes.textField}
                type="text"
                placeholder="Jumlah Item"
                name="jumlah_quantity"
                onChange={handleJumalahQ}
            />
            
            <Button action={handleAdd}>
                Add to Cart
            </Button>
           
                
            
          
            
        </div>
        );
};

export default Item;
import React from "react";
import searchBar from "react-search-bar/lib/components/search-bar";
import './Space.css';


export default function Search(){

    return(

        <form action="/" method="get">
        <label htmlFor="header-search">
        </label>
        <input
            type="text"
            id="header-search"
            placeholder="Type Product Name Here"
            name="s" 
        />
        <button type="submit">Search</button>
    </form>

    );

}
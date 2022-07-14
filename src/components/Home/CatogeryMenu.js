import axios from "axios";
import React, { useEffect, useState } from "react";
import { useContext } from "react";
import { Dropdown, ListGroup } from "react-bootstrap";
import DropdownItem from "react-bootstrap/esm/DropdownItem";
import { DropdownMenu } from "reactstrap";
import CatogeryDropDown from "./CatogeryDropDown";
import { HomeContext } from "./Home";
import SortList from "./SortList";
import './Home.css';


export default function CatogeryMenu(){

    const {catogerySelected, setCatogeySelected} = useContext(HomeContext);



    const url = 'http://localhost:8080/api/products/catogeries';

    const [catogery, setCatogery] = useState([{}]);
    const[catogeryName, setCatogeryName] = useState("");

    useEffect(()=>{
        getCatogery();
    },[]);

    const getCatogery = () =>{
        try {
            axios.get(url).then(Response=>Response.data).then((data) =>{
                setCatogery(data);
                console.log(data);
            });
            
        } catch (error) {
            alert(error.message)
            
        }
    }




    return(

        <div>
            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                    Catogeries
                </Dropdown.Toggle>
                <Dropdown.Menu>
                <DropdownItem onClick={e => setCatogeySelected({type : 0})}>All</DropdownItem>
                {catogery.map(catogeryItem=>(
                <CatogeryDropDown key={catogeryItem.productCatogeryId} catogery={catogeryItem}/>
            ))}
                </Dropdown.Menu>
            </Dropdown>
            <div className="whiteSpace">Sort By </div>
        </div>
    );

}
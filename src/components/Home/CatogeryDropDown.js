import { type } from "@testing-library/user-event/dist/type";
import React, { useContext } from "react";
import { Dropdown } from "react-bootstrap";
import { HomeContext } from "./Home";


export default function CatogeryDropDown({catogery}){

    const {catogerySelected, setCatogeySelected} = useContext(HomeContext);



    return(
    <Dropdown.Item onClick={e => setCatogeySelected({type : catogery.productCatogeryId})} key={catogery.productCatogeryId}>{catogery.productCatogeryName}</Dropdown.Item>
    );
}
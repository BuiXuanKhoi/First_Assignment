import React, { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import CatogeryMenu from "./CatogeryMenu";
import ListProduct from "./ListProduct";
import { createContext, useContext } from "react";


export const HomeContext = React.createContext({});

export const SortContext = React.createContext();

export default function Home(){


    const[catogerySelected, setCatogeySelected] = useState({ 
        type :0,
        sort:"",
        page:"",
        size:"",
    });


    return(

        <HomeContext.Provider value={{catogerySelected, setCatogeySelected}}>
        <Container>
            <Row>
                <Col >
                    <CatogeryMenu/>
                </Col>
                <Col xs={9}>
                    <ListProduct/>
                </Col>
            </Row>
        </Container>
        </HomeContext.Provider>
    );
    
}
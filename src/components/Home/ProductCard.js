import React, { useEffect } from "react";
import { Card, CardImg, Col } from "react-bootstrap";
import { CardBody, CardFooter, CardHeader, CardText, CardTitle } from "reactstrap";
import Button from 'react-bootstrap/Button';
import axios from "axios";


export default function ProductCard({product}){

    const url ="http://localhost:8080/api/carts?product="+product.id;

  
    const getData = ()=>{
        axios.put(url,{
            quantity:1
        });
    }

    return(

        <Col xs={12} md={6} lg={4} key={product.id}>
            <Card style={{width:'18rem'}}>
                <CardHeader></CardHeader>
                <CardImg variant="top" src="https://icdn.dantri.com.vn/thumb_w/680/2022/05/26/iphone-14-pro-crop-1653535329359.jpeg"/>
                <CardBody>
                    <CardTitle>{product.name}</CardTitle>
                    <CardText>{product.describe}</CardText>
                    <Button >Buy Me</Button>
                </CardBody>
                <CardFooter>{product.price}$</CardFooter>
            </Card>
        </Col>


      

    );
}
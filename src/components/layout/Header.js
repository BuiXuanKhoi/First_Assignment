import React from "react";
import { useState } from "react";
import { Card, Container, Form, Nav, Navbar } from "react-bootstrap";
import { CardBody } from "reactstrap";
import Descrip from "./Descrip";
import './Space.css'




export default function Header(props){

    const [signButton, setSignButton] = useState("Sign up");
    const [signUrl, setSignUrl] = useState("/signup");

    return(
        <header>
            <Navbar bg='dark' variant="dark" expand='lg' collapseOnSelect>
                <Container style={{display: "flex", justifyContent: "space-between"}}>
                    <Navbar.Brand href="/" className="spaceNav">Khoi's Shop</Navbar.Brand>
                    <Navbar.Collapse>
                        <Nav>
                        <Nav.Link href="/cart" className="navBrandSpace">Cart</Nav.Link>
                        <Nav.Link href="/order" className="navBarLink">Order</Nav.Link>
                        <Nav.Link href="/user"className="navBarLink" >User Management</Nav.Link>
                        <Nav.Link href="/admin" className="navBarLink">Admin Management</Nav.Link>
                        <Nav.Link href={signUrl} className="navBarLink">{signButton}</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <h5 > Filter By {props.type}</h5>
        </header>
    );

}


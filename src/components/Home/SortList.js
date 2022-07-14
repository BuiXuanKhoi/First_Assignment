import React from "react";
import { ListGroup, ListGroupItem } from "react-bootstrap";


export default function SortList(){
    return(
        <ListGroup as="ul" className="whitespace">
            <ListGroupItem as="li" active>
                Price Increase
            </ListGroupItem>
            <ListGroupItem as="li" >
                Price Decrease
            </ListGroupItem>
        </ListGroup>

    );
}
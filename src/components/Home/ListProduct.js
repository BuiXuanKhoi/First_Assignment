import React, { useContext, useEffect, useState } from "react";
import axios from "axios";
import { Row } from "react-bootstrap";
import ProductCard from "./ProductCard";
import { HomeContext } from "./Home";






export default function ListProduct(){


    const AllUrl = 'http://localhost:8080/api/products';

    const[list, setList] = useState([{}]);

    const {catogerySelected, setCatogeySelected} = useContext(HomeContext);



    useEffect(()=>{
        getList();
    },[catogerySelected]);

    
    const getList =  () =>{
        try {

        if(catogerySelected.type === 0){
                axios.get(AllUrl).then(response=> response.data).then((data) =>{
                    setList(data.content);
    
                });
            }else{

                const url ='http://localhost:8080/api/products/'+catogerySelected.type+'?mode=a&size=10&page=0';

                axios.get(url).then(response=> response.data).then((data) =>{
                    setList(data.content);
                });

            }

          
  
            
        } catch (error) {
            alert(error.message);
            
        }
    }

    console.log(list);


    return(

        <div className="row-wrapper">
            <Row>
                {list.map(product=>(
                    <ProductCard key={product.id} product={product}/>
                ))}
            </Row>
        </div>  
    )
};
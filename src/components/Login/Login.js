import axios from "axios";
import React from "react";
import { useState, useEffect, useRef } from "react";


function Login(){

    const url = 'https://localhost:8000/api/auth/';

    const login = () =>{
        axios.post('${url}login')
    }

    const[username, setUsername] = useState("");
    const[password, setPassword] = useState("");
    const[error, setError] = useState("");
    const[success, setSuccess] = useState(false);

    useEffect(()=>{

    },[])


    return(
        <div>

        </div>

    );

}
import logo from './logo.svg';
import './App.css';
import Header from './components/layout/Header.js';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home/Home.js'
import Cart from './components/Cart/Cart.js';
import React from 'react';


function App() {

  return( 
    <BrowserRouter>
        <Header/>
        <Home/>
    </BrowserRouter>
  


  );
    
}

export default App;

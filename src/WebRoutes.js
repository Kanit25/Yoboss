import React from "react";
import {BrowserRouter,Route,Routes} from "react-router-dom";
import Login from "./pages/Login";
import SignIn from "./pages/SignIn";
import Home from "./pages/Home";
import Error from "./pages/Error";

function WebRoutes(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/signin" element={<SignIn/>}></Route>
        <Route path="*" element={<Error/>}></Route>  
      </Routes>
    </BrowserRouter>
  );
}

export default WebRoutes;

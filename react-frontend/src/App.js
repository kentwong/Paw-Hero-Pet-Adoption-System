import React from "react";
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListPetComponent from './components/pet/ListPetComponent';
import HeaderComponent from './components/layout/HeaderComponent';
import FooterComponent from './components/layout/FooterComponent';
import CreatePetComponent from './components/pet/CreatePetComponent';
import UpdatePetComponent from './components/pet/UpdatePetComponent';
import ViewPetComponent from './components/pet/ViewPetComponent';
import SignUpComponent from './components/user/SignUpComponent';
import LoginComponent from './components/user/LoginComponent';
import ListUserComponent from './components/user/ListUserComponent';
import UpdateUserComponent from "./components/user/UpdateUserComponent";
import HomePageComponent from "./components/HomePageComponent";


function App() {

  return (
    <div className="app">
      <Router>
        <HeaderComponent />
        {/* <HeroImageComponent /> */}
        <div className="">
          <Switch>
            <Route path="/" exact component={HomePageComponent}></Route>
            <Route path="/pets" exact component={ListPetComponent}></Route>
            <Route path="/addpet" exact component={CreatePetComponent}></Route>
            <Route path="/updatepet/:id" exact component={UpdatePetComponent}></Route>
            <Route path="/viewpet/:id" exact component={ViewPetComponent}></Route>
            <Route path="/signup" exact component={SignUpComponent}></Route>
            <Route path="/login" exact component={LoginComponent}></Route>
            <Route path="/logout" exact component={LoginComponent}></Route>
            <Route path="/users" exact component={ListUserComponent}></Route>
            <Route path="/updateuser/:id" exact component={UpdateUserComponent}></Route>
          </Switch>

        </div>
        <FooterComponent />
      </Router>

    </div >

  );
}

export default App;

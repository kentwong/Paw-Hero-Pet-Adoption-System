import React from "react";
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListPetComponent from './components/ListPetComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import HeroImageComponent from './components/HeroImageComponent';
import CreatePetComponent from './components/CreatePetComponent';
import UpdatePetComponent from './components/UpdatePetComponent';
import ViewPetComponent from './components/ViewPetComponent';
import SignUpComponent from './components/SignUpComponent';
import LoginComponent from './components/LoginComponent';
import ListUserComponent from './components/ListUserComponent';


function App() {

  return (
    <div className="app">
      <Router>
        <HeaderComponent />
        {/* <HeroImageComponent /> */}
        <div className="">
          <Switch>
            <Route path="/" exact component={HeroImageComponent}></Route>
            <Route path="/pets" exact component={ListPetComponent}></Route>
            <Route path="/addpet" exact component={CreatePetComponent}></Route>
            <Route path="/updatepet/:id" exact component={UpdatePetComponent}></Route>
            <Route path="/viewpet/:id" exact component={ViewPetComponent}></Route>
            <Route path="/signup" exact component={SignUpComponent}></Route>
            <Route path="/login" exact component={LoginComponent}></Route>
            <Route path="/logout" exact component={LoginComponent}></Route>
            <Route path="/users" exact component={ListUserComponent}></Route>
          </Switch>

        </div>
        <FooterComponent />
      </Router>

    </div >

  );
}

export default App;

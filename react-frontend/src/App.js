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


function App() {
  return (
    <div className="app">
      <Router>
        <HeaderComponent />
        {/* <HeroImageComponent /> */}
        <div className="">
          <Switch>
            <Route path="/" exact component={HeroImageComponent}></Route>
            <Route path="/pets" component={ListPetComponent}></Route>
            <Route path="/addpet" component={CreatePetComponent}></Route>
            <Route path="/updatepet/:id" component={UpdatePetComponent}></Route>
            <Route path="/viewpet/:id" component={ViewPetComponent}></Route>
            <Route path="/signup" component={SignUpComponent}></Route>
            <Route path="/login" component={LoginComponent}></Route>
          </Switch>

        </div>
        <FooterComponent />
      </Router>

    </div >

  );
}

export default App;

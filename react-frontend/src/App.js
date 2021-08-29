import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListPetComponent from './components/ListPetComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import HeroImageComponent from './components/HeroImageComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <HeroImageComponent />
        <div className="container">
          <Switch>
            <Route path="/" component={ListPetComponent}></Route>
            <Route path="/pets" component={ListPetComponent}></Route>
            <ListPetComponent />
          </Switch>

        </div>
        <FooterComponent />
      </Router>

    </div>

  );
}

export default App;

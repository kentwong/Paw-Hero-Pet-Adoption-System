import logo from './logo.svg';
import './App.css';
import ListPetComponent from './components/ListPetComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import HeroImageComponent from './components/HeroImageComponent';

function App() {
  return (
    <div>
      <HeaderComponent />
      <HeroImageComponent />
      <div className="container">
        <ListPetComponent />
      </div>
      <FooterComponent />
    </div>

  );
}

export default App;

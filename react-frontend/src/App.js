import logo from './logo.svg';
import './App.css';
import ListPetComponent from './components/ListPetComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
      <HeaderComponent />
      <div className="container">
        <ListPetComponent />
      </div>
      <FooterComponent />
    </div>

  );
}

export default App;

import React, { Component } from 'react';
import PetService from '../../services/PetService';
import ImageNotAvail from '../../assets/images/imagenotavailable.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPaw } from '@fortawesome/free-solid-svg-icons';

class PetCardsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            pets: []
        }
    }

    componentDidMount() {
        PetService.getPets().then((res) => {
            this.setState({ pets: res.data })
        })
    }



    render() {
        return (
            <div className="container my-5">
                <h2 className="text-center mt-5">🐱Start Your Rescue Pet Search Here🐶 </h2>
                <div className="text-center mt-2 mb-4">
                    <input type="radio" class="btn-check" name="options-outlined" id="dogs" autocomplete="off" onClick={() => {
                        PetService.getPets().then((res) => {
                            this.setState({ pets: res.data.filter(pet => pet.type === 'Dog') })
                        })
                    }} />
                    <label className="btn btn-outline-primary me-2" for="dogs">Dogs</label>

                    <input type="radio" class="btn-check" name="options-outlined" id="cats" autocomplete="off" onClick={() => {
                        PetService.getPets().then((res) => {
                            this.setState({ pets: res.data.filter(pet => pet.type === 'Cat') })
                        })
                    }} />
                    <label className="btn btn-outline-primary me-2" for="cats">Cats</label>

                    <input type="radio" class="btn-check" name="options-outlined" id="allpets" autocomplete="off" onClick={() => {
                        PetService.getPets().then((res) => {
                            this.setState({ pets: res.data })
                        })
                    }} />
                    <label className="btn btn-outline-primary" for="allpets">All Pets</label>
                </div>

                <div className="row">
                    {
                        this.state.pets.map(
                            pet =>
                                <div className="col-sm-6 col-md-4 col-lg-3 my-3" key={pet.petId}>
                                    <div className="card">
                                        <img className="w-100" src={pet.imageUrl === '' ? ImageNotAvail : pet.imageUrl} alt="Pet" />
                                        <div className="card-body">
                                            <h5 className="card-title">{pet.name}</h5>
                                            <div className="card-text-group my-3">
                                                <p className="card-text mb-0"><FontAwesomeIcon icon={faPaw} color="#0d6efd" /> {pet.breed}</p>
                                                <p className="card-text mb-0"><FontAwesomeIcon icon={faPaw} color="#0d6efd" /> {pet.age}</p>
                                                <p className="card-text mb-0"><FontAwesomeIcon icon={faPaw} color="#0d6efd" /> {pet.location}</p>
                                            </div>

                                            <a href={"/viewpet/" + pet.petId} className="btn btn-primary">View Pet</a>
                                        </div>
                                    </div>
                                </div>

                            // <tr key={pet.petId}>
                            //     <td> {pet.petId} </td>
                            //     <td> {pet.name} </td>
                            //     <td> {pet.description} </td>
                            //     <td>
                            //         <button onClick={() => this.viewPet(pet.petId)} className="btn btn-secondary mb-2 me-2">View</button>
                            //     </td>
                            // </tr>
                        )
                    }
                </div>
            </div>
        );
    }
}

export default PetCardsComponent;
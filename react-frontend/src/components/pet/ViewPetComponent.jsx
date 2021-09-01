import React, { Component } from 'react';
import PetService from '../../services/PetService';
import ImageNotAvail from '../../assets/images/imagenotavailable.png';

class ViewPetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            petId: this.props.match.params.id,
            pet: {},
        }
    }

    cancel() {
        this.props.history.push('/pets');
    }

    componentDidMount() {
        PetService.getPetById(this.state.petId).then(res => {
            this.setState({ pet: res.data })
        })
    }

    render() {
        return (
            <div className="container">
                <div className="custom-container">
                    <h2>Pet Details</h2>
                    <div className="row">
                        <div className="col-lg-8 my-3">
                            <img className="w-100" src={ImageNotAvail} alt="Pet" />
                        </div>
                        <div className="col-lg-3 my-3">
                            <span className="badge bg-primary text-wrap">Name</span>
                            <h4>{this.state.pet.name}</h4>

                            <span className="badge bg-primary text-wrap">Type</span>
                            <h4>{this.state.pet.type}</h4>

                            <span className="badge bg-primary text-wrap">Breed</span>
                            <h4>{this.state.pet.breed}</h4>

                            <span className="badge bg-primary text-wrap">Age</span>
                            <h4>{this.state.pet.age}</h4>

                            <span className="badge bg-primary text-wrap">Sex</span>
                            <h4>{this.state.pet.sex}</h4>

                            <span className="badge bg-primary text-wrap">Location</span>
                            <h4>{this.state.pet.location}</h4>

                            <span className="badge bg-primary text-wrap">Adoption Fee</span>
                            <h4>A$ {this.state.pet.adoptionFee}</h4>
                        </div>
                    </div>

                    <span className="fw-bold text-primary">About Me</span>
                    <p>{this.state.pet.description}</p>

                </div>
            </div>
        );
    }
}

export default ViewPetComponent;
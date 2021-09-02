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
        this.adoptPet = this.adoptPet.bind(this);
    }

    cancel() {
        this.props.history.push('/');
    }

    adoptPet(id) {
        this.props.history.push(`/adoptpet/${id}`)
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
                            <img className="w-100" src={this.state.pet.imageUrl === '' ? ImageNotAvail : this.state.pet.imageUrl} alt="Pet" />
                        </div>
                        <div className="col-lg-3 my-3">
                            <span className="badge bg-primary text-wrap">Name</span>
                            <h5>{this.state.pet.name}</h5>

                            <span className="badge bg-primary text-wrap">Type</span>
                            <h5>{this.state.pet.type}</h5>

                            <span className="badge bg-primary text-wrap">Breed</span>
                            <h5>{this.state.pet.breed}</h5>

                            <span className="badge bg-primary text-wrap">Age</span>
                            <h5>{this.state.pet.age}</h5>

                            <span className="badge bg-primary text-wrap">Sex</span>
                            <h5>{this.state.pet.sex}</h5>

                            <span className="badge bg-primary text-wrap">Location</span>
                            <h5>{this.state.pet.location}</h5>

                            <span className="badge bg-primary text-wrap">Adoption Fee</span>
                            <h5>A$ {this.state.pet.adoptionFee}</h5>
                        </div>
                    </div>

                    <span className="fw-bold text-primary">About Me</span>
                    <p>{this.state.pet.description}</p>

                    <button onClick={() => this.adoptPet(this.state.pet.petId)} className="btn btn-primary mb-2 me-2">Adopt Now</button>
                    <button onClick={() => this.cancel()} className="btn btn-danger mb-2 me-2">Back</button>
                </div>
            </div>
        );
    }
}

export default ViewPetComponent;
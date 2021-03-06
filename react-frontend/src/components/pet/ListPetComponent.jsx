import React, { Component } from 'react';
import PetService from '../../services/PetService';

class ListPetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            pets: []
        }

        this.addPet = this.addPet.bind(this);
        this.updatePet = this.updatePet.bind(this);
        this.deletePet = this.deletePet.bind(this);
    }

    componentDidMount() {
        PetService.getPets().then((res) => {
            this.setState({ pets: res.data })
        })
    }

    addPet() {
        this.props.history.push('/addpet');
    }

    updatePet(id) {
        this.props.history.push(`/updatepet/${id}`);
    }

    viewPet(id) {
        this.props.history.push(`/viewpet/${id}`)
    }

    deletePet(id) {
        PetService.deletePet(id);
        this.setState({ pets: this.state.pets.filter(pet => pet.petId !== id) })
    }

    render() {
        return (
            <div className="container my-5">
                <h2 className="text-center">Pets List</h2>

                <div className="row">
                    <table className="table table-Striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th className="">Pet ID</th>
                                <th className="">Pet Type</th>
                                <th className="">Pet Name</th>
                                <th className="">Pet Breed</th>
                                <th className="">Pet Age</th>
                                <th className="">Pet Location</th>
                                <th className="">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.pets.map(
                                    pet =>
                                        <tr key={pet.petId}>
                                            <td> {pet.petId} </td>
                                            <td> {pet.type} </td>
                                            <td> {pet.name} </td>
                                            <td> {pet.breed} </td>
                                            <td> {pet.age} </td>
                                            <td> {pet.location} </td>
                                            <td>
                                                <button onClick={() => this.viewPet(pet.petId)} className="btn btn-secondary mb-2 me-2">View</button>
                                                <button onClick={() => this.updatePet(pet.petId)} className="btn btn-primary mb-2 me-2">Update</button>
                                                <button onClick={() => this.deletePet(pet.petId)} className="btn btn-danger mb-2 me-2">Delete</button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
                {/* <div className="">
                    <button className="btn btn-success" onClick={this.addPet}>Add Pet</button>
                </div> */}
            </div>
        );
    }
}

export default ListPetComponent;
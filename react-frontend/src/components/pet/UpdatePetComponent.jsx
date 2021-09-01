import React, { Component } from 'react';
import PetService from '../../services/PetService';

class UpdatePetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            petId: this.props.match.params.id,
            type: 'dog',
            name: '',
            breed: '',
            ageMonth: '',
            ageYear: '',
            sex: 'male',
            location: '',
            adoptionFee: '',
            description: '',
            imageUrl: ''
        }
        this.handleOnChange = this.handleOnChange.bind(this);
        this.updatePet = this.updatePet.bind(this);
    }

    handleOnChange = e => {
        const { id, value } = e.target;
        this.setState({
            [id]: value
        })
    }

    cancel() {
        this.props.history.push('/pets');
    }

    componentDidMount() {
        PetService.getPetById(this.state.petId).then(res => {
            let pet = res.data;
            this.setState({
                type: pet.type,
                name: pet.name,
                breed: pet.breed,
                ageMonth: pet.age.split(' ')[2],
                ageYear: pet.age.split(' ')[0],
                sex: pet.sex,
                location: pet.location,
                adoptionFee: pet.adoptionFee,
                description: pet.description,
                imageUrl: pet.imageUrl
            })
        })
    }

    updatePet = e => {
        e.preventDefault();
        let year = '';
        let month = '';
        this.state.ageYear > 1 ? year = " years " : year = " year ";
        this.state.ageMonth > 1 ? month = " months " : month = " month ";

        let pet = {
            type: this.state.type,
            name: this.state.name,
            breed: this.state.breed,
            age: this.state.ageYear + year + this.state.ageMonth + month,
            sex: this.state.sex,
            location: this.state.location,
            adoptionFee: this.state.adoptionFee,
            description: this.state.description,
            imageUrl: this.state.imageUrl
        };
        console.log(JSON.stringify(pet));

        PetService.updatePet(pet, this.state.petId).then(res => {
            this.props.history.push('/pets');
        });
    }

    render() {
        return (
            <div className="container">
                <form className="custom-container" onSubmit={this.updatePet}>
                    <h2 className="mb-5">Update Pet Details</h2>
                    <div className="mb-3">
                        <label htmlFor="type" className="form-label">Type <span className="text-danger">*</span></label>
                        <select className="form-select" id="type" defaultValue="dog" onChange={this.handleOnChange}>
                            <option value="dog">Dog</option>
                            <option value="cat">Cat</option>
                            <option value="others">Other Pets</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Name <span className="text-danger">*</span></label>
                        <input type="text" className="form-control" id="name" value={this.state.name} onChange={this.handleOnChange} required></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="breed" className="form-label">Breed <span className="text-danger">*</span></label>
                        <input type="text" className="form-control" id="breed" value={this.state.breed} onChange={this.handleOnChange} required></input>
                    </div>
                    <div className="row mb-3">
                        <div className="col-md-6">
                            <label htmlFor="age" className="form-label">Age (Year) <span className="text-danger">*</span></label>
                            <input type="number" className="form-control" id="ageYear" min="0" value={this.state.ageYear} onChange={this.handleOnChange} required></input>
                        </div>
                        <div className="col-md-6">
                            <label htmlFor="age" className="form-label">Age (Month) <span className="text-danger">*</span></label>
                            <input type="number" className="form-control" id="ageMonth" min="0" value={this.state.ageMonth} onChange={this.handleOnChange} required></input>
                        </div>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="sex" className="form-label">Sex <span className="text-danger">*</span></label>
                        <select className="form-select" id="sex" defaultValue="male" onChange={this.handleOnChange}>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="location" className="form-label">Location <span className="text-danger">*</span></label>
                        <input type="text" className="form-control" id="location" value={this.state.location} onChange={this.handleOnChange} required></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="adoptionFee" className="form-label">Adoption adoptionFee (AUD) <span className="text-danger">*</span></label>
                        <input type="number" className="form-control" id="adoptionFee" min="0" step="0.01" value={this.state.adoptionFee} onChange={this.handleOnChange} required></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="description" className="form-label">Description <span className="text-danger">*</span></label>
                        <textarea className="form-control" id="description" rows="3" value={this.state.description} onChange={this.handleOnChange} required></textarea>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="imageUrl" className="form-label">Upload Image</label>
                        <input type="file" className="form-control" id="imageUrl" value={this.state.imageUrl} onChange={this.handleOnChange}></input>
                    </div>
                    <button type="submit" className="btn btn-success me-2">Save</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default UpdatePetComponent;
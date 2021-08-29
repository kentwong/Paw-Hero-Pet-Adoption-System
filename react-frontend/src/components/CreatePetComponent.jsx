import React, { Component } from 'react';

class CreatePetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            type: 'dog',
            name: '',
            breed: '',
            age: '',
            sex: 'male',
            location: '',
            fee: '',
            description: '',
            file: ''
        }
        this.handleOnChange = this.handleOnChange.bind(this);
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

    addPet = e => {
        e.preventDefault();
        let pet = {
            type: this.state.type,
            name: this.state.name,
            breed: this.state.breed,
            age: this.state.age,
            sex: this.state.sex,
            location: this.state.location,
            fee: this.state.fee,
            description: this.state.description,
            file: this.state.file
        };
        console.log(JSON.stringify(pet));
    }

    render() {
        return (
            <div>
                <h1 className="my-4">Create New Pet</h1>
                <form className="addpetform">
                    <div className="mb-3">
                        <label htmlFor="type" className="form-label">Type</label>
                        <select className="form-select" id="type" defaultValue="dog" onChange={this.handleOnChange}>
                            <option value="dog">Dog</option>
                            <option value="cat">Cat</option>
                            <option value="others">Other Pets</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <input type="text" className="form-control" id="name" value={this.state.name} onChange={this.handleOnChange}></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="breed" className="form-label">Breed</label>
                        <input type="text" className="form-control" id="breed" value={this.state.breed} onChange={this.handleOnChange}></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="age" className="form-label">Age (months)</label>
                        <input type="number" className="form-control" id="age" min="0" value={this.state.age} onChange={this.handleOnChange}></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="sex" className="form-label">Sex</label>
                        <select className="form-select" id="sex" defaultValue="male" onChange={this.handleOnChange}>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="location" className="form-label">Location</label>
                        <input type="text" className="form-control" id="location" value={this.state.location} onChange={this.handleOnChange}></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="fee" className="form-label">Adoption Fee (AUD)</label>
                        <input type="number" className="form-control" id="fee" min="0" value={this.state.fee} onChange={this.handleOnChange}></input>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="description" className="form-label">Description</label>
                        <textarea className="form-control" id="description" rows="3" value={this.state.description} onChange={this.handleOnChange}></textarea>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="file" className="form-label">Upload Image</label>
                        <input type="file" className="form-control" id="file" value={this.state.file} onChange={this.handleOnChange}></input>
                    </div>
                    <button type="submit" className="btn btn-success me-2" onClick={this.addPet}>Add</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default CreatePetComponent;
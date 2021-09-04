import React, { useState } from 'react';
import PetService from '../../services/PetService';

function CreatePetComponent(props) {

    const [type, setType] = useState('Dog');
    const [name, setName] = useState('');
    const [breed, setBreed] = useState('');
    const [ageMonth, setAgeMonth] = useState('');
    const [ageYear, setAgeYear] = useState('');
    const [sex, setSex] = useState('Male');
    const [location, setLocation] = useState('');
    const [adoptionFee, setAdoptionFee] = useState('');
    const [description, setDescription] = useState('');
    const [imageUrl, setImageUrl] = useState('');
    const [loading, setLoading] = useState(false);


    const uploadImage = async e => {

        const files = e.target.files;
        const data = new FormData();
        data.append('file', files[0]);
        data.append('upload_preset', 'pawheroimages');
        setLoading(true);

        const res = await fetch("https://api.cloudinary.com/v1_1/pawhero/image/upload", {
            method: 'POST',
            body: data
        })

        const file = await res.json();
        setImageUrl(file.url);
        setLoading(false);
    }

    const cancel = () => {
        props.history.push('/pets');
    }

    const addPet = e => {
        e.preventDefault();
        let year = '';
        let month = '';
        ageYear > 1 ? year = " years " : year = " year ";
        ageMonth > 1 ? month = " months " : month = " month ";

        let pet = {
            type: type,
            name: name,
            breed: breed,
            age: ageYear + year + ageMonth + month,
            sex: sex,
            location: location,
            adoptionFee: adoptionFee,
            description: description,
            imageUrl: imageUrl
        };
        console.log(JSON.stringify(pet));

        PetService.createPet(pet).then(res => {
            props.history.push('/pets');
        });
    }

    return (
        <div className="container">
            <form className="custom-container" onSubmit={addPet}>
                <h2 className="mb-5">Create New Pet</h2>
                <div className="mb-3">
                    <label htmlFor="type" className="form-label">Type <span className="text-danger">*</span></label>
                    <select className="form-select" id="type" defaultValue="dog" onChange={e => setType(e.target.value)}>
                        <option value="Dog">Dog</option>
                        <option value="Cat">Cat</option>
                        <option value="Others">Other Pets</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name <span className="text-danger">*</span></label>
                    <input type="text" className="form-control" id="name" value={name} onChange={e => setName(e.target.value)} required></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="breed" className="form-label">Breed <span className="text-danger">*</span></label>
                    <input type="text" className="form-control" id="breed" value={breed} onChange={e => setBreed(e.target.value)} required></input>
                </div>
                <div className="row mb-3">
                    <div className="col-md-6">
                        <label htmlFor="age" className="form-label">Age (Year) <span className="text-danger">*</span></label>
                        <input type="number" className="form-control" id="ageYear" min="0" value={ageYear} onChange={e => setAgeYear(e.target.value)} required></input>
                    </div>
                    <div className="col-md-6">
                        <label htmlFor="age" className="form-label">Age (Month) <span className="text-danger">*</span></label>
                        <input type="number" className="form-control" id="ageMonth" min="0" value={ageMonth} onChange={e => setAgeMonth(e.target.value)} required></input>
                    </div>
                </div>
                <div className="mb-3">
                    <label htmlFor="sex" className="form-label">Sex <span className="text-danger">*</span></label>
                    <select className="form-select" id="sex" defaultValue="male" onChange={e => setSex(e.target.value)}>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="location" className="form-label">Location <span className="text-danger">*</span></label>
                    <input type="text" className="form-control" id="location" value={location} onChange={e => setLocation(e.target.value)} required></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="adoptionFee" className="form-label">Adoption adoptionFee (AUD) <span className="text-danger">*</span></label>
                    <input type="number" className="form-control" id="adoptionFee" min="0" step="0.01" value={adoptionFee} onChange={e => setAdoptionFee(e.target.value)} required></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Description <span className="text-danger">*</span></label>
                    <textarea className="form-control" id="description" rows="3" value={description} onChange={e => setDescription(e.target.value)} required></textarea>
                </div>
                <div className="mb-3">
                    <label htmlFor="imageUrl" className="form-label">Upload Image</label>
                    <input type="file" className="form-control" id="imageUrl" onChange={uploadImage}></input>
                </div>
                <button type="submit" className="btn btn-success me-2">Add</button>
                <button className="btn btn-danger" onClick={cancel}>Cancel</button>
            </form>
        </div>
    );

}

export default CreatePetComponent;
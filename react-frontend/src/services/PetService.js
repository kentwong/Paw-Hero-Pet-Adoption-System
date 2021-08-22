import axios from 'axios';

const PET_API_BASE_URL = "http://localhost:8081/pawhero/api/v1/pets";

class PetService {
    getPets() {
        return axios.get(PET_API_BASE_URL);
    }
}

export default new PetService();
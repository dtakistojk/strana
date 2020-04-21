import axios from "axios";
import {GET_POSTS} from "./types";

export const getPosts = () => async dispatch =>{
    const res = await axios.get(("http://localhost:8080/api/posts/all"));
        dispatch ({
            type: GET_POSTS,
            payload:res.data
        });
};
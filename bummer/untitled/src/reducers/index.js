import  {combineReducers} from "redux";
import randomPostReducer from "./randomPostReducer";

export default  combineReducers(
    {
        post:randomPostReducer
    }
)
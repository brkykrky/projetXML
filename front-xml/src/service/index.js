import { GET_ONE_STB , GET_HELPED , GET_LIST_STB , 
    GET_LIST_STB_XML , GET_PROJECT_INFO , GET_ONE_STB_XML , 
    DELETE_ONE_STB , POST_STB_XML , GET_STB_SEARCH
} from "../utils/endpoints";
import { axiosInstanceHtml , axiosInstanceXml } from "./axios";




export const getListStbService = async () => axiosInstanceHtml.get(GET_LIST_STB);
export const getListStbXmlService = async () => axiosInstanceXml.get(GET_LIST_STB_XML);
export const getProjetInfoService =async () => await axiosInstanceHtml.get(GET_PROJECT_INFO);
export const getHelpService = async () => await axiosInstanceHtml.get(GET_HELPED);
  


export const getOneStbService = async (id) => axiosInstanceHtml.get(`${GET_ONE_STB}/${id}`);
export const getOneStbXmlService = async (id) =>  axiosInstanceXml.get(`${GET_ONE_STB_XML}/${id}`);
export const postStbService = async (data) => await axiosInstance.get(POST_STB_XML,data);
export const deleteOneStbService  = async (id) =>  axiosInstanceXml.get(`${DELETE_ONE_STB}/${id}`);


export const searchStbsService = async (search) => await axiosInstanceXml.get(`${GET_STB_SEARCH}`,{params:search});
import  {useState} from "react" ; 
import { GET_ONE_STB_XML  , GET_ONE_STB  , DELETE_ONE_STB} from "../utils/endpoints";
import {deleteOneStbService, getListStbService,getListStbXmlService} from "../service/index" ;
import {Box , Typography} from "@mui/material" ;
import {useNavigate} from "react-router-dom";

const StbInfo = ({id,title , description , date , entity , deleteOne}) => {
    const navigate = useNavigate() ; 
    return (
    <Paper sx={{width:'100%',borderRadius:'25px' , margin:'15px 0px'}}>
        <Typography>Titre : {title}</Typography> 
        <Typography>Description:{description}</Typography>
        <Typography>Date de validation de la Stb : {date}</Typography>
        <Typography>Entité Client:{entity}</Typography>

        <Box>
            <Button sx={{margin:"10px"}} bgcolor="red" onClick={async ()=>{
                    await deleteOne(id)
            }}>Delete</Button> 
            <Button  sx={{margin:"10px"}} onClick={()=>{
                navigate(`stb/xml/${id}`)
            }}>Detail</Button>
        </Box>
    </Paper>
    )
} ; 


const listSTB = () => { 

    const [loading , setLoading] = useState(true);
    const [error,setError] = useState(false) ;
    const [data , setData] =  useState();
 
    useEffect( ()=>{
       const getListStbXmlService = async () => {
         try {
          const {response} = await getListStbXmlService() ;
          console.log("response => " , response) ;
          setData(response.data) ; 
          setLoading(false) ; 
         } catch (error) {
          console.log("what is the error",error) ; 
          setLoading(false) ;
          setError(true);
         }
       }
       getListStbXml();
 
    },[]) ;

    const deleteOne = async (id) => {
        // on fait notre requete si le code est bon on supprime de la merde ni
       
    }

        return (
            <>{
                loading ? <>Loading....</>
                : 
                <>
                   {error ? <>Error....</>
                   :
                  <> There is some data </>
                   }
                </>
            }</>
        )
} ;

export default listSTB ; 
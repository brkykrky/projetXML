import { useState , useEffect } from "react";
import { getProjetInfoService} from "../service/index" ;
import Box from "@mui/material/Box" ; 
const Home = () => {
   const [loading , setLoading] = useState(true);
   const [error,setError] = useState(false) ;
   const [data , setData] =  useState() ;

   useEffect( ()=>{
      const getProjetInfo = async () => {
        try {
         const {response} = await getProjetInfoService() ;
         console.log("response => " , response) ;
         setData(response.data) ; 
         setLoading(false) ; 
        } catch (error) {
         console.log("what is the error",error) ; 
         setLoading(false) ;
         setError(true);
        }
      }
      getProjetInfo();

   },[]) ;
     return (
        <>{
            loading ? <>Loading....</>
            : 
            <>
               {error ? <>Error....</>
               :
               <div dangerouslySetInnerHTML={{ __html: data }} />
               }
            </>
        }</>
     )
} ; 

export default Home ; 
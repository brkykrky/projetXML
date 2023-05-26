import { useState  , useEffect } from "react";
import {getHelpService} from "../service/index"

const Help = () => {
    const [loading , setLoading] = useState(true) ; 
    const [error , setError] = useState(false) ; 
    const [data , setData] = useState(); 


    useEffect(()=>{
        const getHelp = async () => {
            try{
                const {response} =  await getHelpService();
                console.log("response => "  , response) ;
            }catch(e) {
                console.log("error" ,e.response) ;
                setData(e.response.data) ; 
                setError(true) ; 
            }
            finally{
                setLoading(false) ;
            }
            
        }

        getHelp() ;
    },[])

return (
    <>{
        loading ? <>Loading....</>
        : 
        <>
           {error ? <div dangerouslySetInnerHTML={{ __html: data }} />

           :
            <>Help</>
           }
        </>
    }</>
)
} ;
export default Help ; 
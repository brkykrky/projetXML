import  {useState} from "react" ; 
import { GET_ONE_STB_XML  , GET_ONE_STB } from "../utils/endpoints";
import {getOneStbXmlService,getOneStbService} from "../service/index" ;

const DetailedSTB = () => { 
    const [loading , setLoading] = useState(true);
    const [error,setError] = useState(false) ;
    const [data , setData] =  useState();
    const {id} = useParams();
 
    useEffect( ()=>{
       const getOneSTBXml = async (id) => {
         try {
          const {response} = await getOneStbXmlService(id) ;
          console.log("response => " , response) ;
          setData(response.data) ; 
          setLoading(false) ; 
         } catch (error) {
          console.log("what is the error",error) ; 
          setLoading(false) ;
          setError(true);
         }
       }
       getOneSTBXml(id);
 
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


export default DetailedSTB   ; 
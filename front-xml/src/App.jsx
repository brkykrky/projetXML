import { Route , Routes } from "react-router-dom"
import Layout from "./layout" ;
import Home from "./pages/home" ;
import InsertNewStb from "./pages/insertNewStb";
import Help from "./pages/help";
function App() {

  return (
 
      <Routes>
          <Route  path='/' element={<Layout />}>
            <Route index element={ <Home />}/> 
            <Route path="stb/resume/xml" element={ <div>stb/resume/xml</div>}/>
            <Route path="stb/resume" element={<>stb/resume</>} />
            <Route path="stb/xml/:id" element={ <div>xml/detail</div>}/>
            <Route path="stb/html/:id" element={<div>html/:id</div>} />
            <Route path="stb/insert" element={<InsertNewStb />}/>
            <Route path="help" element={ <Help />}/>
            <Route path="*" element={<div>Error 404</div>}/>
          </Route>
      </Routes>
  
  )
}

export default App


import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {BrowserRouter as Router,Route} from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateComponent from './components/CreateComponent';
import ViewComponent from'./components/ViewComponent';
import ListComponents from './components/ListComponents';
import UpdateComponent from './components/UpdateComponent'; 
import { Switch } from 'react-router-dom';


function App() {
  return (
    <div>
    <Router>
          <HeaderComponent />
            <div className="container">
                <Switch> 
                      <Route path = "/" exact component = {ListComponents }></Route>
                      <Route path = "/employees" component = {ListComponents }></Route>
                      <Route path = "/add-employee/:id" component = {CreateComponent}></Route>
                      <Route path = "/view-employee/:id" component = {ViewComponent}></Route>
                      <Route path = "/update-employee/:id" component = {UpdateComponent}></Route> 
                </Switch>
            </div>
            <br/>
          <FooterComponent />
    </Router>
</div>


  );
}
export default App;
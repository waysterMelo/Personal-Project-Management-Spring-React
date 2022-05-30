import { Provider } from "react-redux";
import store from "./store";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Router, Route } from "react-router-dom";
import Header from "./component/layout/Header";
import Dashboard from "./component/Dashboard";
import AddProject from "./component/project/AddProject";
import { createBrowserHistory } from 'history';
const newHistory = createBrowserHistory();



function App() {
  return (
     <Provider store={store}>
         <Router history={newHistory} >
             <div className="App">
                 <Header />
                 <Route exact path="/dashboard" component={Dashboard} />
                 <Route exact path="/addProject" component={AddProject} />
             </div>
         </Router>
     </Provider>
  );
}

export default App;

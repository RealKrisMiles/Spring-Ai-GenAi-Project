import React, { useState } from "react";

function RecipeGenerator(){
    const[ingredients,setIngredients] = useState('')
    const[cuisine,setCuisine] = useState('')
    const[retrictions,setRetrictions] = useState('')
    const[response,setResponse] = useState('')

    const responses= async()=>{
        const response = await fetch(`localhost:8081/generate-image?ingredients=${ingredients}&cuisine=${cuisine}&dietaryRestrictions=${retrictions}`)
        const data = await response.text();
        setResponse(data);
    }
    return(
       <div>
        <h2>Generate a Recipe</h2>
        <input type="text" value={ingredients} onChange={(e)=>setIngredients(e.target.value)} placeholder="Enter ingredients" />
         <input type="text" value={cuisine} onChange={(e)=>setCuisine(e.target.value)} placeholder="Enter cuisine" />
          <input type="text" value={retrictions} onChange={(e)=>setRetrictions(e.target.value)} placeholder="Enter retrictions" />
          <button onClick={responses}>Find Recipe</button>
        <div className="output">
            <pre className="recipe-text"></pre>
            {response}</div>

       </div>
    )
}
export default RecipeGenerator;
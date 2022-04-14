import { useEffect, useState } from "react"
import { get } from "../../http/httpClient"
import { useParams } from "react-router-dom"


function ShowAdvertismentsList(props) {
    const { category } = useParams()
    const [advertisements, setAdvertisements] = useState([])

    useEffect((e) => {
        get(`${category}/advertisements`, true, 8088).then((c) => {
            c.json().then((c) => {
                setAdvertisements(c)
                
            })
        }).catch(console.log("Error"))
    }, [advertisements])
    if (props.loggedin) {
        if (!advertisements.length > 0) {
            return (
                <>
                <p>There is no advertisements</p>
                </>
            )
        } else {
            return (<>
        
                <ul>
                    {advertisements.map((element, i) => {
                        return(
                        <li key={i}>
                            <a href={`/advertisement/${Object.entries(element)[0][0]}`}>{Object.entries(element)[0][1]}</a>
                        </li>)
                    })}
                </ul>
                </>)
        }
       
    }
    else {
        return null
    }

}

export default ShowAdvertismentsList
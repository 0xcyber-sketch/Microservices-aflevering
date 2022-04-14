import { useEffect, useState } from "react"
import { get } from "../../http/httpClient"
import { useParams } from "react-router-dom"

function Advertisement(props) {
    const { id } = useParams()
    const [ advertisement, setAdvertisement ] = useState([])
    useEffect((e) => {
        get(`advertisement/${id}`, true, 8088).then((c) => {

            c.json().then((c) => {
                setAdvertisement(c)
            })
        }).catch(console.log("Error"))
    }, [])



    if (props.loggedin) {
        console.log(advertisement);
        return (
            <>
            <img src={advertisement.imageUrl.url} alt=""></img>
            <h1>{advertisement.headerText.value}</h1>
            <p>Category: {"" + advertisement.category.toLowerCase()} Type: {"" + advertisement.type.toLowerCase()}</p>
            <p>{advertisement.bodyText.value}</p>
            <p>Price: {advertisement.price.value} USD</p>
            <p>Phonenumber: {advertisement.phoneNumber.value}</p>

            

              
            </>
        )
    }
    else {
        return null
    }

}

export default Advertisement
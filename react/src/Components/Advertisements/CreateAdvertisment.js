import {  useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { post } from "../../http/httpClient.js"


function CreateAdvertisment(props) {
    const navigate = useNavigate()

    const [category, setCategory] = useState("Car")
    const [type, setType] = useState("Sale")
    const [headerText, setHeaderText] = useState("")
    const [headerTextErrors, setheaderTextErrors] = useState([""])
    const [bodyText, setBodyText] = useState("")
    const [bodyTextErrors, setBodyTextErrors] = useState([""])
    const [price, setPrice] = useState("")
    const [priceErrors, setPriceErrors] = useState([""])
    const [phoneNumber, setPhoneNumber] = useState("")
    const [phoneNumberErrors, setPhoneNumberErrors] = useState([""])
    const [imageUrl, setImageUrl] = useState("")
    const [imageUrlErrors, setImageUrlErrors] = useState([""])


    const optionsTypes = [
        'Sale', 'Purchase', 'Rent'
    ];

    const optionsCategories = [
        "Car", "Food", "Tools", "Animals", "Toys", "Collectables"

    ];

    const handleSubmit = (e) => {


        if (priceErrors.length > 0) {
            alert("Ad failed to be created due to price not being a number")
            
        }
        else if (bodyTextErrors.length > 0) {
            alert("Ad failed to be created due to body text being empty")
        }
        else if (headerTextErrors.length > 0) {
            alert("Ad failed to be created due to header text being empty")
        }
        else if (phoneNumberErrors.length > 0) {
            alert("Ad failed to be created due to phone number being empty")
        }
        else if (imageUrlErrors.length > 0) {
            alert("Ad failed to be created due to image URL being empty")
        }
        else {
            e.preventDefault();
            post("createAd", getPayload(), true, 8088).then((res) => {
                res.json().then((resp) => {

                    //navigate('/loggedIn')

                })

            }).catch(error => {
                console.log(error)
                alert("Ad failed to be created")
            })
        }




    }
    const getPayload = () => {
        return { category: category.toUpperCase().trim(), type: type.toUpperCase().trim(), headerText: headerText, bodyText: bodyText, price: price, phoneNumber: phoneNumber, imageUrl: imageUrl }
    }

    const handleOnChange = (e) => {

        const { name, value } = e.target

        if (name === "headerText") {
            setHeaderText(value)
            setheaderTextErrors(validateHeaderText(value))
        }
        else if (name === "category") {
            setCategory(value)
        }
        else if (name === "type") {
            setType(value)
        }
        else if (name === "bodyText") {
            setBodyText(value)
            setBodyTextErrors(validateBodyText(value))
        }
        else if (name === "price") {
            setPrice(parseFloat(value))
            setPriceErrors(validatePrice(value))

        }

        else if (name === "phonenumber") {
            setPhoneNumber(value)
            setPhoneNumberErrors(validatePhoneNumber(value))
        }

        else if (name === "imageURL") {
            setImageUrl(value)
            setImageUrlErrors(validateImageUrl(value))
        }

    }

    const validatePrice = (value) => {

        if (!parseFloat(value)) {
            return ["Price needs to be a decimal number"]
        }
        return []
    }

    const validateBodyText = (value) => {

        if (value === "") {
            return ["Body text can't be empty"]
        }
        return []
    }
    const validateHeaderText = (value) => {

        if (value === "") {
            return ["Header text can't be empty"]
        }
        return []
    }
    const validateImageUrl = (value) => {

        if (value === "") {
            return ["Image URL  can't be empty"]
        }
        return []
    }
    const validatePhoneNumber = (value) => {

        if (value === "") {
            return ["Phone number can't be empty"]
        }
        return []
    }

    if (props.loggedin) {
        return (
            <>
                <form onSubmit={handleSubmit}>
                    <input placeholder="Header text" name="headerText" type='text' value={headerText.value} onChange={handleOnChange} />
                    <div className="form-element-error">{headerTextErrors.map((error, index) => <p key={index}>{error}</p>)}</div>
                    <select name="category" onChange={handleOnChange}>
                        {optionsCategories.map((element, i) => {
                            return (
                                <option key={i} value={element}>{element}</option>
                            )
                        })}
                    </select>
                    <select name="type" onChange={handleOnChange}>
                        {optionsTypes.map((element, i) => {
                            return (
                                <option key={i} value={element}>{element}</option>
                            )
                        })}
                    </select>
                    <textarea placeholder="Body text" name="bodyText" value={bodyText.value} onChange={handleOnChange} rows="4" cols="50" style={{ resize: "none" }}></textarea>
                    <div className="form-element-error">{bodyTextErrors.map((error, index) => <p key={index}>{error}</p>)}</div>
                    <input placeholder="price" name="price" type='text' value={price.value} onChange={handleOnChange} />
                    <div className="form-element-error">{priceErrors.map((error, index) => <p key={index}>{error}</p>)}</div>
                    <input placeholder="phonenumber" name="phonenumber" type='text' value={phoneNumber.value} onChange={handleOnChange} />
                    <div className="form-element-error">{phoneNumberErrors.map((error, index) => <p key={index}>{error}</p>)}</div>
                    <input placeholder="Image Url" name="imageURL" type='text' value={imageUrl.value} onChange={handleOnChange} />
                    <div className="form-element-error">{imageUrlErrors.map((error, index) => <p key={index}>{error}</p>)}</div>

                    <button >Create</button>
                </form>

            </>)
    }
    else {

        return null
    }

}

export default CreateAdvertisment
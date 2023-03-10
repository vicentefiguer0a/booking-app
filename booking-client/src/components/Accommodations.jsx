import React, { useState } from "react";
import { Link, useParams } from "react-router-dom";
import AccommodationPerks from "./AccommodationPerks";

const Accommodations = () => {
    // TODO: Fix perks array for request.
    const {action} = useParams();

    // const [title, setTitle] = useState("");
    // const [address, setAddress] = useState("");
    // const [addedPhotos, setAddedPhotos] = useState([]);
    // const [description, setDescription] = useState("");
    // const [perks, setPerks] = useState([]);
    // const [extraInfo, setExtraInfo] = useState("");
    // const [checkIn, setCheckIn] = useState("");
    // const [checkOut, setCheckOut] = useState("");
    // const [guests, setGuests] = useState(1);

    const [accommodation, setAccommodation] = useState({
        id: "",
        title: "",
        address: "",
        addedPhotos: [],
        description: "",
        perks: [],
        extraInfo: "",
        checkIn: "",
        checkOut: "",
        guests: 1,
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setAccommodation({...accommodation, [e.target.name]: value});
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(accommodation);
    }


    
    return (
        <div>
            {action !== "add" && (
                <div className="my-3 text-center">
                    <Link to={"/account/accommodations/add"} className="inline-flex gap-1 bg-blue-500 text-white px-4 py-2 rounded-full">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
                            <path fillRule="evenodd" d="M12 3.75a.75.75 0 01.75.75v6.75h6.75a.75.75 0 010 1.5h-6.75v6.75a.75.75 0 01-1.5 0v-6.75H4.5a.75.75 0 010-1.5h6.75V4.5a.75.75 0 01.75-.75z" clipRule="evenodd" />
                        </svg>
                        Add Accommodation
                    </Link>
                </div>
            )}
            {action === "add" && (
                <div>
                    <form>
                        <div>
                            <label className="block mt-3 text-xl">Title</label>
                            <p className="text-gray-400 text-xs">Accommodation title should be short and catchy.</p>
                            <input
                                type="text"
                                name="title"
                                value={accommodation.title}
                                onChange={(e) => handleChange(e)}
                                placeholder="Example: Gorgeous Loft Near Downtown"
                                className="rounded-lg w-full border my-2 p-2"
                            />
                        </div>

                        <div className="my-8">
                            <label className="block mt-3 text-xl">Address</label>
                            <p className="text-gray-400 text-xs">Full address to accommodation.</p>
                            <input
                                type="text"
                                name="address"
                                value={accommodation.address}
                                onChange={(e) => handleChange(e)}
                                placeholder="Full address"
                                className="rounded-lg w-full border my-2 p-2"
                            />
                        </div>

                        <div className="my-8">
                            <label className="block mt-3 text-xl">Photos</label>
                            <p className="text-gray-400 text-xs">The more photos, the better.</p>
                            <div className="mt-2 grid grid-cols-3 md:grid-cols-4 lg:grid-cols-6">
                                <button className="flex justify-center items-center border bg-transparent rounded-2xl py-3 gap-1">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-5 h-5">
                                        <path strokeLinecap="round" strokeLinejoin="round" d="M3 16.5v2.25A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75V16.5m-13.5-9L12 3m0 0l4.5 4.5M12 3v13.5" />
                                    </svg>
                                    Upload
                                </button>
                            </div>
                        </div>

                        <div className="my-8">
                            <label className="block mt-3 text-xl">Description</label>
                            <p className="text-gray-400 text-xs">Detailed description of accommodation.</p>
                            <textarea
                                type="text"
                                name="description"
                                value={accommodation.description}
                                onChange={(e) => handleChange(e)}
                                rows={8}
                                placeholder="Description"
                                className="rounded-lg w-full border my-2 p-2"
                            />
                        </div>

                        <div className="my-8">
                            <label className="block mt-3 text-xl">Perks</label>
                            <p className="text-gray-400 text-xs">Select all perks that come with the accommodation.</p>
                            <div className="grid gap-2 grid-cols-2 md:grid-cols-3 lg:grid-cols-6 mt-3">
                                <AccommodationPerks selected={perks} />
                            </div>
                        </div>

                        <div className="my-8">
                            <label className="block mt-3 text-xl">Extra Info</label>
                            <p className="text-gray-400 text-xs">Accommodation rules, standards, etc.</p>
                            <textarea
                                name="extraInfo"
                                value={accommodation.extraInfo}
                                onChange={(e) => handleChange(e)}
                                rows={6}
                                className="rounded-lg w-full border my-2 p-2"
                            />
                        </div>

                        <div className="mb-8">
                            <label className="block mt-3 text-xl mb-1">Check In/Out & Max Guests Info</label>
                            <p className="text-gray-400 text-xs">Add check in and check out times, along with the maximum number of guests allowed.</p>
                            <p className="text-gray-400 text-xs mb-2">Remember to leave a time window to allow for cleaning of accommodation.</p>
                            <div className="grid sm:grid-cols-3 gap-2">
                                <div>
                                    <label className="block mt-3 text-sm">Check In Time</label>
                                    <input
                                        type="text"
                                        name="checkIn"
                                        value={accommodation.checkIn}
                                        onChange={(e) => handleChange(e)}
                                        placeholder="11:30 am"
                                        className="rounded-lg w-full border my-2 p-2"
                                    />
                                </div>
                                <div>
                                    <label className="block mt-3 text-sm">Check Out Time</label>
                                    <input
                                        type="text"
                                        name="checkOut"
                                        value={accommodation.checkOut}
                                        onChange={(e) => handleChange(e)}
                                        placeholder="12:00 pm"
                                        className="rounded-lg w-full border my-2 p-2"
                                    />
                                </div>
                                <div>
                                    <label className="block mt-3 text-sm">Max Guests</label>
                                    <input
                                        type="text"
                                        name="guests"
                                        value={accommodation.guests}
                                        onChange={(e) => handleChange(e)}
                                        placeholder="5"
                                        className="rounded-lg w-full border my-2 p-2"
                                    />
                                </div>
                            </div>
                        </div>

                        <div>
                            <button
                                onClick={handleSubmit}
                                className="w-full bg-blue-500 text-white rounded-xl p-3">
                                Add Accommodation
                            </button>
                        </div>
                    </form>
                </div>
            )}
        </div>
    );
}

export default Accommodations;
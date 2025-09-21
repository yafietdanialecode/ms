


export default function LoginPage() {


    return <form className="w-[100vw] bg-gray-600 pt-4 h-[100vh] gap-3 flex flex-col items-center justify-center">

    <p className="text-center text-sm">acme.com</p>
    <h1 className="text-center text-3xl">Log in</h1>

    <label htmlFor="username" className="flex gap-2 items-center">
        <span>Username</span>
        <input type="text" id="username" className="p-2 bg-white rounded text-black" />
    </label>

    <label htmlFor="password" className="flex gap-2 items-center">
        <span>Password</span>
        <input type="password" id="password" className="p-2 bg-white rounded text-black" />
    </label>

    <button type="submit" className="bg-white p-2 pl-6 pr-6 text-black rounded-full hover:bg-gray-300 active:bg-black active:text-white">Log in</button>

    </form>

}
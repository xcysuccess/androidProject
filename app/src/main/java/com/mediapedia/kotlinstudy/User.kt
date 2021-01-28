package com.mediapedia.kotlinstudy

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class User() : Parcelable{
    var name:String? = "tomxiang"
    var age:Int = 32

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        age = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val username: String,
  val isSeen: Boolean = false
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)

data class Location(
    val image: String,
    val name: String,
    val isSeen: Boolean = false,
    val icon: Int? = null
)

val places = arrayOf(
    "London-Tower Bridge",
    "Madame Tussad-London",
    "London Eye-London",
    "Covent Garden",
    "London Bridge",
    "East India",
    "East Ham",
    "Search"
)

data class Songs(
    val image: String,
    val name: String,
    val isSeen: Boolean = false
)

val musics = arrayOf(
    "Happy Moments-Inod",
    "Beautiful Day-Jonathan Roy",
    "One Kiss-Dua Lipa",
    "Despasito-Luis Fonsi",
    "People-Libianca",
    "Calm Down-Rema",
)

val usernames = arrayOf(
    "Stor Ee",
    "Nia Ny C",
    "Op Ioke",
    "Asho Ke",
    "Dark Emarlds",
    "Bed Tan",
    "Shrish",
    "Mat Do",
    "Phill Sohn",
    "Deit Ch"
)


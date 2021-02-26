package xyz.pistis.squidplayer

import android.net.Uri


interface OnSongClickListener {
    fun onClick(songUri: Uri)
}
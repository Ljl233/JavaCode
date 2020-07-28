package dataClass

sealed class PlayerState


object Idle : PlayerState()

class Playing(val song: Song) : PlayerState() {
    fun start(): PlayerState {
        return Idle
    }

}

class Error(val errorInfo: ErrorInfo) : PlayerState() {


}

class Player {

    var state: PlayerState = Idle
    fun play(song: Song) {

        this.state = when (val sta = this.state) {
            Idle -> {
                Idle
            }
            is Playing -> {
                Playing(song).also { Playing::start }
            }
            is Error -> {
                Playing(song).also { Playing::start }
            }
        }
    }
}

class Song {

}


class ErrorInfo {

}

package com.uludag.can.simplemvp.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.uludag.can.simplemvp.R
import com.uludag.can.simplemvp.root.App
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inject dagger
        (application as App).mApplicationComponent.inject(this)

        btnSave.setOnClickListener {
            mPresenter.loginButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.setView(this)
        mPresenter.getCurrentUser()
    }

    override fun getFirstName(): String {
        return etFirstName.text.toString()
    }

    override fun getLastName(): String {
        return etLastName.text.toString()
    }

    override fun showUserNotAvailable() {
        Toast.makeText(this, "Error! The user is not available", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "First name or last name cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(firstName: String) {
        etFirstName.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        etLastName.setText(lastName)
    }

}

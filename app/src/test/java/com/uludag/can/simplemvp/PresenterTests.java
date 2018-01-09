package com.uludag.can.simplemvp;

import com.uludag.can.simplemvp.login.LoginContract;
import com.uludag.can.simplemvp.login.LoginPresenter;
import com.uludag.can.simplemvp.models.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterTests {

    LoginContract.Model mockLoginModel;
    LoginContract.View mockView;
    LoginPresenter mPresenter;
    User mUser;

    @Before
    public void setUp() throws Exception {
        mockLoginModel = mock(LoginContract.Model.class);
        mUser = new User(1, "Albert", "Einstein");
        mockView = mock(LoginContract.View.class);

        mPresenter = new LoginPresenter(mockLoginModel);
        mPresenter.setView(mockView);
    }

    @Test
    public void loadUserFromRepositoryWhenValidUserIsPresent() {
        when(mockLoginModel.getUser()).thenReturn(mUser);
        mPresenter.getCurrentUser();

        // Verify that the getUser() model method called only once
        verify(mockLoginModel, times(1)).getUser();

        // Verify that the setFirstName() and setLastName() view methods called only once
        verify(mockView, times(1)).setFirstName("Albert");
        verify(mockView, times(1)).setLastName("Einstein");
        // Verify that the showUserNotAvailable() view method never called
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockLoginModel.getUser()).thenReturn(null);
        mPresenter.getCurrentUser();

        // Verify that the getUser() model method called only once
        verify(mockLoginModel, times(1)).getUser();

        // Verify that the setFirstName() and setLastName() view methods called only once
        verify(mockView, never()).setFirstName("Albert");
        verify(mockView, never()).setLastName("Einstein");
        // Verify that the showUserNotAvailable() view method never called
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldsAreEmpty() {
        // First name will return an empty string
        when(mockView.getFirstName()).thenReturn("");
        mPresenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        // This time the last name will return an empty string
        when(mockView.getFirstName()).thenReturn("Albert");
        when(mockView.getLastName()).thenReturn("");
        mPresenter.saveUser();

        // Called two times, once before and once for this time
        verify(mockView, times(2)).getFirstName();
        // Called only once this time
        verify(mockView, times(1)).getLastName();
        // Called two times, once before and once for this time
        verify(mockView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveValidUser() {
        // First name and last name will return the data
        when(mockView.getFirstName()).thenReturn("Albert");
        when(mockView.getLastName()).thenReturn("Einstein");
        mPresenter.saveUser();

        // Called two times
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        // Make sure the repository saved the user
        verify(mockLoginModel, times(1))
                .createUser(123, "Albert", "Einstein");

        // Verify that the user informed with a toast message
        verify(mockView, times(1)).showUserSavedMessage();
    }

}

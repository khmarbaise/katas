package com.soebes.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExceptionTest {
  
  void thisMethodThrowException() {
    throw new IllegalArgumentException("This method has failed");
  }
  
  void thisMethodThrowExceptionWithCause() {
    throw new IllegalArgumentException("This method has failed", new Throwable("The cause is this."));
  }
  
  @Test
  void check_that_exception_is_throw() {
    assertThatIllegalArgumentException().isThrownBy(() -> thisMethodThrowException());
  }
  
  @Test
  void check_that_exception_is_throw_with_appropriate_message() {
    assertThatIllegalArgumentException().isThrownBy(() -> thisMethodThrowException())
      .withMessage("This method has failed");
  }
  
  @Test
  void check_that_exception_is_throw_with_appropriate_cause() {
    assertThatIllegalArgumentException().isThrownBy(() -> thisMethodThrowExceptionWithCause())
      .withMessage("This method has failed");
  }
}

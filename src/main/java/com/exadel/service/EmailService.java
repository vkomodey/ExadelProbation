package com.exadel.service;

import java.util.List;

public interface EmailService {
   public List<String> getAllEmailsById(List<Long> listId);
}

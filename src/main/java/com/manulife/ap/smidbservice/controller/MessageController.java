package com.manulife.ap.smidbservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manulife.ap.smidbservice.infra.repo.MessageRepository;
import com.manulife.ap.smidbservice.model.Message;

/**
 * @author Brenda H Yu
 *
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Message getMessageById(@PathVariable("id") String id) {
		return messageRepository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Message modifyMessageById(@PathVariable("id") String id, @Valid @RequestBody Message message) {
		message.setId(id);
		return messageRepository.save(message);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Message createMessage(@Valid @RequestBody Message message) {
		return messageRepository.save(message);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deletePet(@PathVariable String id) {
		messageRepository.deleteById(id);
		return true;
	}
}
